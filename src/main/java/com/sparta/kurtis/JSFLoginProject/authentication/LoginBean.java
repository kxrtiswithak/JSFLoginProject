package com.sparta.kurtis.JSFLoginProject.authentication;

import com.sparta.kurtis.JSFLoginProject.entity.Credentials;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Named
@RequestScoped
public class LoginBean {

    @Inject
    Credentials credential;

    @Inject
    SecurityContext securityContext;

    @Inject
    ExternalContext externalContext;

    @Inject
    FacesContext facesContext;

    public Credentials getCredential() {
        return credential;
    }

    public void setCredential(Credentials credential) {
        this.credential = credential;
    }

    public void submit() throws IOException {
        switch (continueAuthentication()) {
            case SEND_CONTINUE:
                facesContext.responseComplete();
                break;
            case SEND_FAILURE:
                facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login unsuccessful", null));
                break;
            case SUCCESS:
                externalContext.redirect(externalContext.getRequestContextPath() + "welcome");

        }
    }

    private AuthenticationStatus continueAuthentication() {
        return securityContext.authenticate(
                (HttpServletRequest) externalContext.getRequest(),
                (HttpServletResponse) externalContext.getResponse(),
                AuthenticationParameters.withParams().credential(new UsernamePasswordCredential(credential.getUsername(), credential.getPassword()))
        );
    }

    public String logout() throws ServletException {
        ExternalContext externalContext = facesContext.getExternalContext();
        ((HttpServletRequest) externalContext.getRequest()).logout();
        return "/login.xhtml?faces-redirect=true";
    }
}
