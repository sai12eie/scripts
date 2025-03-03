/// <reference path="sahi_apis.ts" />
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var AssertCart = /** @class */ (function () {
    function AssertCart() {
    }
    AssertCart.prototype.verifyTotal = function ($total) {
        _assertExists(_textbox("total"));
        _assertVisible(_textbox("total"));
        _assertEqual($total, _getValue(_textbox("total")));
    };
    return AssertCart;
}());
var Cart = /** @class */ (function (_super) {
    __extends(Cart, _super);
    function Cart() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    Cart.prototype.login = function ($username, $password) {
        _navigateTo("/demo/training/");
        _setValue(_textbox("user"), $username);
        _setPassword(_password("password"), $password);
        _click(_submit("Login"));
    };
    Cart.prototype.addBooks = function ($qJava, $qRuby, $qPython) {
        _setValue(_textbox("q"), $qJava);
        _setValue(_textbox("q[1]"), $qRuby);
        _setValue(_textbox("q[2]"), $qPython);
        _click(_button("Add"));
    };
    Cart.prototype.logout = function () {
        _click(_button("Logout"));
    };
    Cart.prototype.doAll = function () {
        this.login("test", "MgkKEQBU");
        this.addBooks("2", "3", "1");
        this.verifyTotal(1550);
        this.logout();
    };
    return Cart;
}(AssertCart));
