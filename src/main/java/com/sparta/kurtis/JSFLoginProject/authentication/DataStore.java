package com.sparta.kurtis.JSFLoginProject.authentication;

import com.sparta.kurtis.JSFLoginProject.entity.Credentials;
import com.sparta.kurtis.JSFLoginProject.service.CredentialsRepository;

import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.HashSet;
import java.util.Map;

public class DataStore implements IdentityStore {
    @Override
    public CredentialValidationResult validate(Credential credential) {
        UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
        CredentialsRepository credentialsRepository = new CredentialsRepository();
        Map<String, Credentials> allCredentials = credentialsRepository.getAllCredentialsMap();


        Credentials credentialDetails = allCredentials.get(usernamePasswordCredential.getCaller());

        if (credentialDetails != null) {
            if (credentialDetails.getPassword().equals(usernamePasswordCredential.getPasswordAsString())) {
                HashSet<String> roles = new HashSet<>();
                String role = credentialDetails.getIsAdmin() == 1 ? "ADMIN" : "USER";
                roles.add(role);
                return new CredentialValidationResult(credentialDetails.getUsername(), roles);
            }
        }
        return CredentialValidationResult.NOT_VALIDATED_RESULT;
    }

}
