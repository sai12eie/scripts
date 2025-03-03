_include("cart_lib.js");
var cart = new Cart();
cart.login("test", "MgkKEQBU");
cart.addBooks("2", "3", "1");
cart.verifyTotal(1550);
cart.logout();
// do again for nested function calls
cart.doAll();
_navigateTo("/demo");
var $links = _collect("_link", "/.*/");
_assertEqual(54, $links.length);
