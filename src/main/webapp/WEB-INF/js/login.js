$(function() {
    $(".btn").click(function() {
       loginRegisterSwitch();
    });
});

function loginRegisterSwitch(){
    $(".form-signin").toggleClass("form-signin-left");
    $(".form-signup").toggleClass("form-signup-left");
    $(".frame").toggleClass("frame-long");
    $(".signup-inactive").toggleClass("signup-active");
    $(".signin-active").toggleClass("signin-inactive");
    // $("#signUp").removeClass('signup-inactive').addClass('signup-active');
    // $("#signIn").removeClass('signin-active').addClass('signin-inactive');
    $(".forgot").toggleClass("forgot-left");
    $(this).removeClass("idle").addClass("active");
}

function showAlertAfterRegistration(){
    $('div.alert.alert-success').show();
}

$("a.btn-signup").click(function() {
    var firstName = $("form.form-signup input.firstName").val();
    var lastName = $("form.form-signup input.lastName").val();
    var email = $("form.form-signup input.email").val();
    var password = $("form.form-signup input.password").val();
    var cpassword = $("form.form-signup input.cpassword").val();
    if (firstName == '' || lastName == '' || email == '' || password == '' || cpassword == '') {
        alert("Please fill all fields...!!!!!!");
    } else if ((password.length) < 2) {
        alert("Password should atleast 8 character in length...!!!!!!");
    } else if (!(password).match(cpassword)) {
        alert("Your passwords don't match. Try again?");
    } else {

        let userRegistration ={
            firstName : firstName,
            lastName : lastName,
            email: email,
            password: password
        };
        $.post("registration", userRegistration, function(data) {
            if (data == 'Success') {
                $("form")[0].reset();
                $("form")[1].reset();
                loginRegisterSwitch();
                showAlertAfterRegistration();
            }
        });
    }
});

$("a.btn-signin").click(function() {

    var email = $("form.form-signin input.email").val();
    var password = $("form.form-signin input.password").val();

    if ( email == '' || password == '') {
        alert("Please fill login form!");
    }

    let userLogin ={
        email: email,
        password: password
    };
    $.post("login", userLogin, function(data) {
        if(data != ''){
            let customUrl = '';
            let urlContent = window.location.href.split('/');
            for (let i = 0; i < urlContent.length - 1; i++) {
                customUrl += urlContent[i] + '/'
            }
            customUrl += data.destinationUrl;
            window.location = customUrl;
        }

        $("form")[1].reset();
    });

});








