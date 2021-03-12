package com.sparta.kurtis.JSFLoginProject.authentication;

import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.HashSet;

public class InMemoryIdentityStore implements IdentityStore {

    @Override
    public CredentialValidationResult validate(Credential credential) {
        UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
        if (usernamePasswordCredential.getCaller().equals("admin")
                && usernamePasswordCredential.getPasswordAsString().equals("admin")) {
            HashSet<String> roles = new HashSet<>();
            roles.add("ADMIN");
            return new CredentialValidationResult("admin", roles);
        } else if (usernamePasswordCredential.getCaller().equals("John")
                && usernamePasswordCredential.getPasswordAsString().equals("random")) {
            HashSet<String> roles = new HashSet<>();
            roles.add("random");
            return new CredentialValidationResult("random user", roles);
        } else {
            return CredentialValidationResult.NOT_VALIDATED_RESULT;
        }
    }
}
