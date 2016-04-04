package edu.uta.courses.util;

import edu.uta.courses.repository.domain.WwwUser;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by me on 10.2.2015.
 */
public class UserUtil {

    public static String getSHA256Password(String clearText, String salt) {
        String hashedPw =  new ShaPasswordEncoder(256).encodePassword(clearText, salt);
        return hashedPw;
    }

    public static WwwUser getWwwUser() {
        if (isAnonymous()) {
            // or empty wwwuser or throw an exception...?
            return null;
        }
        WwwUser user =
                (WwwUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }

    public static boolean isAnonymous() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return true;
        }
        return false;
    }

    public static boolean hasSuperUserAccess() {
        if (isAnonymous()) return false;
        WwwUser user =
                (WwwUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.isSuperuser();
    }

    public static boolean hasModeratorAccess() {
        if (isAnonymous()) return false;
        WwwUser user =
                (WwwUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.isModerator();
    }


}
