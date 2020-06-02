package org.t246osslab.keycloak.locale;

import org.keycloak.locale.DefaultLocaleSelectorProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

import java.util.Locale;

/**
 * @author
 */
public class AcceptLanguageLocaleSelectorProvider extends DefaultLocaleSelectorProvider {

    private KeycloakSession session;

    public AcceptLanguageLocaleSelectorProvider(KeycloakSession session) {
        super(session);
        this.session = session;
    }

    @Override
    public Locale resolveLocale(RealmModel realm, UserModel user) {
        for (Locale acceptableLanguage : this.session.getContext().getRequestHeaders().getAcceptableLanguages()) return acceptableLanguage;
        return super.resolveLocale(realm, user);
    }
}
