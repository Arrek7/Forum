function validateRegisterForm() {
    var login = document.getElementById("login-field");
    var password = document.getElementById("password-field");
    var password2 = document.getElementById("password2-field");
    var name = document.getElementById("name-field");
    var surname = document.getElementById("surname-field");

    var loginRegex = new RegExp("^\\w{4,}$");
    var passwordRegex = new RegExp("^\\w{5,}$");
    var nameRegex = new RegExp("^[A-Z]{1}[a-z]{2,}$");
    var surnameRegex = new RegExp("^[A-Z]{1}[a-z]+([ -]{1}[A-Z]{1}[a-z]+)?$");

    var result = true;

    if(!loginRegex.test(login.value)) {
        result = false;
        login.style.background = "#fac0c0";
    } else {
        login.style.background = null;
    }

    if(!passwordRegex.test(password.value) ||
    !passwordRegex.test(password2.value) ||
    password.value !== password2.value) {
        result = false;
        password.style.background = "#fac0c0";
        password2.style.background = "#fac0c0";
    } else {
        password.style.background = null;
        password2.style.background = null;
    }

    if(!nameRegex.test(name.value)) {
        result = false;
        name.style.background = "#fac0c0";
    } else {
        name.style.background = null;
    }

    if(!surnameRegex.test(surname.value)) {
        result = false;
        surname.style.background = "#fac0c0";
    } else {
        surname.style.background = null;
    }

    return result;
}

function validateLoginForm() {
    var login = document.getElementById("login-field");
    var password = document.getElementById("password-field");
    var loginRegex = new RegExp("^\\w{4,}$");
    var passwordRegex = new RegExp("^\\w{5,}$");
    var result = true;
    if(!loginRegex.test(login.value)) {
        result = false;
        login.style.background = "#fac0c0";
    } else {
        login.style.background = null;
    }
    if(!passwordRegex.test(password.value)) {
        result = false;
        password.style.background = "#fac0c0";
    } else {
        password.style.background = null;
    }
    return result;
}
