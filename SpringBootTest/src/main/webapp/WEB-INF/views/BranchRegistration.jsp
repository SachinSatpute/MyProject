<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>    
<link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<script type="text/javascript" src="js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="js/bootstrap-datepicker.es.min.js"></script>

<script src="js/ModalPopupWindow.js" type="text/javascript"></script>
<!------ Include the above in your HEAD tag ---------->
<script>
$(function () {
    $('#datetimepicker1').datepicker({
        format: "dd/mm/yyyy",
        language: "es",
        autoclose: true,
        todayHighlight: true
    });
});
</script>
<script>
function check(input) {
    if (input.value != document.getElementById('password').value) {
        input.setCustomValidity('Password Must be Matching.');
        //alert("confirm password not match with password");
    } else {
        // input is valid -- reset the error message
        input.setCustomValidity('');
    }
}
</script>
<script>
$(function(){
	$.validator.setDefaults({
		highlight: function(element){
			$(element)
			.closest('.form-group')
			.addClass('has-error')
		},
		unhighlight: function(element){
			$(element)
			.closest('.form-group')
			.removeClass('has-error')
		}
	});
	
	$.validate({
		rules:
		{	
		    password: "required",
			birthDate: "required",
			weight: {
			    required:true,
			    number:true
			},
			height:  {
			    required:true,
			    number:true
			},
			email: {
				required: true,
				email: true
			}
		},
			messages:{			
				email: {
				required: true,
				email: true
			}
		},
				password: {
					required: " Please enter password"
				},
				birthDate: {
					required: " Please enter birthdate"
				},
				email: {
					required: ' Please enter email',
					email: ' Please enter valid email'
				},
				weight: {
					required: " Please enter your weight",
					number: " Only numbers allowed"
				},
				height: {
					required: " Please enter your height",
					number: " Only numbers allowed"
				},
				phonenumber: {
					required: " Please enter your phonenumber",
					number: " Only numbers allowed"
				},
			}
			
	});
});
</script>

<script>
var modalWin = new CreateModalPopUpObject();
modalWin.SetLoadingImagePath("images/loading.gif");
modalWin.SetCloseButtonImagePath("images/remove.gif");
function  ShowMessageWithAction(){
	//alert("TEst");
    //ShowConfirmationMessage(message, height, width, title,onCloseCallBack, firstButtonText, onFirstButtonClick, secondButtonText, onSecondButtonClick);
    modalWin.ShowConfirmationMessage('Do you want to confirm to add Branch',200,400,'Branch Confirmation',null,'Yes',/*Action1*/null,'No',/*Action2*/ null, 95, 140);
   // alert("TEst 2");
 }
</script>

<style>
body {
    /* background: url('https://static-communitytable.parade.com/wp-content/uploads/2014/03/rethink-target-heart-rate-number-ftr.jpg') fixed;*/
    background-color:#D3D3D3;
    background-size: cover;
}
.container{
	 margin-top: 0.001%;
	 margin-bottom: 3.001%;
}
*[role="form"] {
    max-width: 550px;
    padding: 15px;
    margin: 0 auto;
    border-radius: 0.3em;
    background-color: #f2f2f2;
}

*[role="form"] h2 { 
    font-family: 'Open Sans' , sans-serif;
    font-size: 30px;
    font-weight: 500;
    color: #000000;
    margin-top: 3%;
    text-align: center;
    text-transform: uppercase;
    letter-spacing: 4px;
}

</style>

<body>
<%
String nsec = request.getParameter("nsec");
System.out.println("Testing nsec in branch registration"+nsec);
%>
<input type="hidden" name="nsec" value=<%=nsec%>/>
<div class="container">
			<!--  <h4><a align="center" style="color:VIOLET;" href="${pageContext.request.contextPath}/Backtohome?nsec=<%=nsec%>">BACK</a></h4>  -->
             <p></p>
             <form  method="POST" action="${pageContext.request.contextPath}/setBranch?nsec=<%=nsec%>" class="form-horizontal" role="form">
                <span><h5 align="center" href="#" style="color:RED;">${brregistrationmsg} </h5></span>
                <h3 align ="center">Branch Registration</h3>
                <div class="form-group">
                    <label for="branchName" class="col-sm-3 control-label">Branch Name</label>
                    <div class="col-sm-9">
                        <input type="text" name="branchname" id="BranchName" placeholder="Branch Name" class="form-control" autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email* </label>
                    <div class="col-sm-9">
                        <input type="email" name="email" id="email" placeholder="Email" class="form-control" name= "email">
                    </div>
                </div>
                <div class="form-group">
                    <label for="phoneNumber" class="col-sm-3 control-label">Phone number </label>
                    <div class="col-sm-9">
                        <input type="tel" name="phonenumber" id="phoneNumber" placeholder="Phone number" class="form-control"   pattern="^\d{10}$" required>
                        <span class="help-block">Your phone number should be 10 Digit Number  </span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <span class="help-block">*Required fields</span>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-block" onclick="ShowMessageWithAction()">Register</button>
            </form> <!-- /form -->
        </div> <!-- ./container -->        
</body>
</html>        