package com.github.firulapp.constants;

public class ApiPaths {

    public static final String API_PATTERN = "/api/.*";
    public static final String BASE_URL = "/api";

    /**
     * User endpoints' URLs
     */
    public static final String USER_ENDPOINTS_URL = BASE_URL + "/user";
    public static final String LOGIN_URL = "/login";
    public static final String REGISTER_URL = "/register";
    public static final String LOGOUT_URL = "/logout";
    public static final String GET_BY_TYPE = "/type";
    public static final String GET_BY_ID = "/{id}";

    /**
     * Params endpoints' URLs
     */
    public static final String PARAM_ENDPOINTS_URL = BASE_URL + "/param";
    public static final String SPECIES_ENDPOINTS = "/species";
    public static final String SPECIES_BY_ID = SPECIES_ENDPOINTS + "/{id}";
    public static final String BREED_ENDPOINTS = "/breed";
    public static final String BREED_BY_ID = BREED_ENDPOINTS + "/{id}";
    public static final String BREED_BY_SPECIES_ID = BREED_ENDPOINTS+ SPECIES_BY_ID;
    public static final String CONDUCT_RULE_ENDPOINTS = "/rules";
    public static final String CONDUCT_RULE_BY_ID = CONDUCT_RULE_ENDPOINTS + "/{id}";
    public static final String HELP_PAGE_ENDPOINTS = "/help";
    public static final String HELP_PAGE_BY_ID = HELP_PAGE_ENDPOINTS + "/{id}";
    public static final String SERVICE_TYPE_ENDPOINTS = "/service/type";
    public static final String SERVICE_TYPE_BY_ID = SERVICE_TYPE_ENDPOINTS + "/{id}";
    public static final String PET_CARE_ENDPOINTS = "/petcare";
    public static final String PET_CARE_BY_ID = PET_CARE_ENDPOINTS + "/{id}";

}
