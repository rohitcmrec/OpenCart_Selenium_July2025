package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
    public static final String LOGINPAGE_TITLE = "Account Login";
    public static final String LOGINPAGE_URL = "route=account/login";

    public static final String ACCOUNTSPAGE_TITLE = "My Account";
    public static final String ACCOUNTSPAGE_URL = "route=account/account";

    public static final List<String> ACCOUNTSPAGE_HEADERLIST = Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");
    public static final String REGISTER_SUCCESS_MSG = "Your Account Has Been Created!";
}
