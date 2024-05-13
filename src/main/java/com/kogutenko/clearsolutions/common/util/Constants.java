package com.kogutenko.clearsolutions.common.util;

public interface Constants {

    interface Authentication {
        String AUTH_BAD_CREDENTIALS = "User email and password not found";
        String AUTH_INVALID_XSRF_TOKEN = "Invalid XSRF-TOKEN";
        String AUTH_INVALID_ACCESS_TOKEN = "Invalid access token";
        String AUTH_INVALID_REFRESH_TOKEN = "Invalid refresh token";
        String AUTH_USER_SESSION_NOT_FOUND = "User session not found";
        String AUTH_USER_SESSION_CANNOT_BE_DELETED = "Active user session cannot be deleted";
        String AUTH_NO_ACCESS_RIGHTS = "User does not have rights to perform this action";
        String AUTH_EMAIL_ALREADY_EXISTS = "User with such email already exists";
        String AUTH_RECENT_PASSWORD_CANNOT_BE_REUSED = "Recent password cannot be reused";
        String AUTH_INCORRECT_CURRENT_PASSWORD = "Incorrect current password";
        String AUTH_INCORRECT_ACTIVATION_CODE = "Incorrect activation code";
        String AUTH_INCORRECT_CONFIRMATION_CODE = "Incorrect confirmation code";
    }

    interface Invitation {
        String INVITATION_NOT_FOUND = "Invitation not found";
        String INVITATION_REGISTERED_CANNOT_BE_CHANGED = "Invitation with REGISTERED status cannot be changed";
        String INVITATION_CANCELED = "Invitation has been canceled";
        String INVITATION_INCORRECT_TOKEN = "Incorrect invitation token";
    }

    interface CSVHeader {
        String HEADER_ROLE = "ROLE";
        String HEADER_EMAIL = "EMAIL";
        String HEADER_LAST_NAME = "LAST NAME";
        String HEADER_FIRST_NAME = "FIRST NAME";
        String HEADER_PHONE = "PHONE";
        String HEADER_ADDRESS = "ADDRESS";
        String HEADER_BIRTH_DATE = "BIRTH DATE";
        String HEADER_COMPANY = "COMPANY";
    }

    interface User {
        String USER_NOT_FOUND = "User not found";
        String USER_EMAIL_NOT_FOUND = "User email not found";
        String USER_ID_NOT_FOUND = "User id not found";
        String USER_INCORRECT_CONFIRMATION_CODES = "Incorrect confirmation codes";
        String USER_CANNOT_BE_ACTIVATED_OR_BANNED = "Deleted users cannot be activated or banned";
        String USER_SETTING_NOT_FOUND = "User setting not found";
    }

    interface File {
        String FILE_ID_NOT_FOUND = "File id not found";
    }

    interface VirtualFleet {
        String VIRTUAL_FLEET_ID_NOT_FOUND = "Virtual fleet id not found";
        String VIRTUAL_FLEET_NOT_FOUND = "Virtual fleet type not found";
    }

    interface Airport {
        String AIRPORT_ID_NOT_FOUND = "Airport id not found";
        String AIRPORT_HAS_RELATION_TO_TRIPS = "Airport has relation to trips";
    }

    interface Api {
        String PUBLIC_APIS = "/api/v1/public/**";
        String PRIVATE_APIS = "/api/v1/private/**";
    }

    interface CostBasisType {
        String COST_TYPE_BASIS_ID_NOT_FOUND = "Cost type basis id not found";
    }

    interface Trip {
        String TRIP_ID_NOT_FOUND = "Trip id not found";
        String TRIP_NOT_FOUND = "Trip not found";
    }

    interface Operator {
        String OPERATOR_ID_NOT_FOUND = "Operator id not found";
        String OPERATOR_HAS_ASSIGNED_QUOTES = "Operator has assigned quotes";
    }

    interface Quote {
        String QUOTE_ID_NOT_FOUND = "Quote id not found";
        String QUOTE_DOES_NOT_SENT = "Quote hasn't been sent to the customer yet";
        String QUOTE_ALREADY_SELECTED = "Quote has already been selected";
    }

    interface AircraftOperator {
        String AIRCRAFT_OPERATOR_ID_NOT_FOUND = "Aircraft/Operator id not found";
    }

    interface QuoteItem {
        String QUOTE_ITEM_ID_NOT_FOUND = "Quote item id not found";
        String QUOTE_ITEM_ALREADY_SELECTED = "You cannot create a new one because the aircraft has already been selected.";
    }

    interface Aircraft {
        String AIRCRAFT_ID_NOT_FOUND = "Aircraft id not found";
        String AIRCRAFT_HAS_ASSIGNED_QUOTES = "Aircraft has assigned quotes";
    }

    interface UserTripAssign {
        String USER_TRIP_ASSIGN_ID_NOT_FOUND = "User trip assign id not found";
        String USER_TRIP_ASSIGN_ACCESS_DENIED = "User does not have rights to this trip, pls contact admin";
        String USER_TRIP_ASSIGN_ALREADY_EXIST = "This user for this trip already assigned";
    }

    interface Windget {
        String WIDGET_LABEL_TRIP_NOT_FOUND = "Widget label not found";
        String WIDGET_DEFAULT_CANNOT_DELETE = "Default widget label cannot be deleted";
        String WIDGET_LABEL_DEFAULT_CANNOT_UPDATE = "Default widget label cannot be renamed";
        String WIDGET_LABEL_CANNOT_UPDATE_TO_DEFAULT = "Widget label cannot be renamed to default";
    }

    interface Mailing {
        String EMAIL_REPORT_ID_NOT_FOUND = "Email report id not found";
        String MAIL_CONFIG_ID_NOT_FOUND = "Mailing config id not found";
    }
}
