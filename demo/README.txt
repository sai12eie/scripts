SahiPro's sample automated tests for OpenCart(e-commerce application). 
SahiPro provides powerful API's which enable users to create robust and reliable tests across different browsers and OS. 
SahiPro also offers a wide range of features such as assertions, data driven capabilities, Business-Driven Test Automation (BDTA), Accessor Repository(AR), image comparison, authentication and many more which are essential for testing opencart application. 

	1. Opencart Application: OpenCart is free open source e-commerce platform for online merchants. OpenCart provides a professional and reliable foundation from which to build a successful online store.

	2. We have automated the opencart sample application for the following scenarios.
		Automation.dd.csv
			|
			| - Admin.dd.csv(suite)
					|
					| - CreateNewCoupon.s.csv
					| - CreateNewProduct.s.csv
					| - RegisterNewUser.s.csv
		
			| - Checkout.dd.csv(suite) - [depends: Admin.dd.csv]
					|
					| - CheckoutProduct.s.csv
					| - CheckoutProductWithValidCoupon.s.csv
					| - Should_Fail_Invalid_Coupon.s.csv
		
			
			NOTE: Checkout.dd.csv suite file is dependent on Admin.dd.csv, Since it will wait for the Admin.dd.csv to complete its execution and then Checkout.dd.csv gets executed.
			
		CreateNewCoupon.s.csv - Login to the opencart application as an admin, Delete a coupon if exists as a part of pre-requisites and then create a new coupon.
		
		CreateNewProduct.s.csv - Login to the opencart application as an admin, Create a manufacture if not exists and then delete a product if exists as a part of pre-requisites and then create a new product.
		
		RegisterNewUser.s.csv - This scenario file handles the input form validations for each field, deletes the user if exists as a part of pre-requisites register and registers new user with mandate details. 
		
		CheckoutProduct.s.csv - Login to the opencart application as an admin, Delete a product if exists and then create a new product. 
		Admin will also delete the user if exists as a part of pre-requisites. Now, New user will be registered with the basic details such as, Firstname, Lastname, Email, Telephone and Password. Shipping Information will be added for the product delivery. 
		This testcase will make sure the order history is empty for the new registered user. Search a product that has been created and add it to the cart and verify the cart details. 
		Checkout the product by adding the billing address, shipping address and payment method, verify the total and place the order.
	
		CheckoutProductWithValidCoupon.s.csv - Login to the opencart application as an admin, Delete a coupon if exists and then create a new coupon, delete a product if exists and then create a new product.
		Admin will also delete the user if exists as a part of pre-requisites. Now, New user will be registered with the basic details such as, Firstname, Lastname, Email, Telephone and Password. Shipping Information will be added for the product delivery.
		This testcase will make sure the order history is empty for the new registered user. Search a product that has been created and add it to the cart and verify the cart details. Apply the valid coupon which was created and verify the coupon discount after applying the coupon.
		Checkout the product by adding the billing address, shipping address and payment method, verify the total and place the order.

		Should_Fail_Invalid_Coupon.s.csv - Login to the opencart application as an admin, Delete a coupon if exists and then create a new coupon, delete a product if exists and then create a new product.
		Admin will also delete the user if exists as a part of pre-requisites. Now, New user will be registered with the basic details such as, Firstname, Lastname, Email, Telephone and Password. Shipping Information will be added for the product delivery.
		This testcase will make sure the order history is empty for the new registered user. Search a product that has been created and add it to the cart and verify the cart details. Here we have passed an invalid data(Invalid coupon) and verifying the scenario file should fail.
		Checkout the product by adding the billing address, shipping address and payment method, verify the total and place the order.

	3. Execution of the Automation.dd.csv - This data driven suite can be executed by selecting a particular tag/tags for its individual execution.
		a. all - If 'all' tag is selected for the execution then all the scenario files will be executed. Final status of this execution will be 'FAILURE'. Individual scenario files status would be 'SUCCESS', 'SUCCESS', 'SUCCESS', 'SUCCESS', 'SUCCESS' and 'FAILURE' respectively.
		
		b. validCoupon - If 'validCoupon' tag is selected for the execution then it will execute only the CheckoutProductWithValidCoupon.s.csv scenario file. Final status of this execution will be 'SUCCESS'. Individual scenario file status will be 'SUCCESS'.
		
		c. invalidCoupon - If 'invalidCoupon' tag is selected for the execution then it will execute only the Should_Fail_Invalid_Coupon.s.csv scenario file. Final status of this execution will be 'FAILURE'. Individual scenario file status will be 'FAILURE'.
		
	4. Features of Sahi Pro used in this opencart application automation.
		a. Business-Driven Test Automation (BDTA)
				http://localhost:9999/_s_/docs/using-sahi/business-driven-test-automation.html
				Or, https://resources.sahipro.com/docs/using-sahi/business-driven-test-automation.html
		
		b. Scenario (s.csv)
			| - Passing argument as an object
			| - Passing argument as value
			
				http://localhost:9999/_s_/docs/using-sahi/scenario.html
				Or, https://resources.sahipro.com/docs/using-sahi/scenario.html
		
		c. Data driven testing
				http://localhost:9999/_s_/docs/using-sahi/scenario-java.html#Data%20driven%20testing
				Or, https://resources.sahipro.com/docs/using-sahi/scenario-java.html#Data%20driven%20testing
		
		d. Accessor Repository (AR)
				http://localhost:9999/_s_/docs/using-sahi/sahi-script-editor.html#Accessor%20Repository%20Details
				Or, https://resources.sahipro.com/docs/using-sahi/sahi-script-editor.html#Accessor%20Repository%20Details
		
		e. Relational API's
				http://localhost:9999/_s_/docs/sahi-apis/relation-apis.html
				Or, https://resources.sahipro.com/docs/sahi-apis/relation-apis.html
		
		f. Data Driven Suite (dd.csv)
				http://localhost:9999/_s_/docs/using-sahi/data-driven-suites.html
				Or, https://resources.sahipro.com/docs/using-sahi/data-driven-suites.html
		
		g. Multi browser testing.
		