/// <reference path="sahi_apis.ts" />

class AssertCart {
    verifyTotal($total:number|string){
        _assertExists(_textbox("total"));
        _assertVisible(_textbox("total"));
        _assertEqual($total, _getValue(_textbox("total")));
    }
}

class Cart extends AssertCart {
    login ($username:string, $password:string) {
        _navigateTo("/demo/training/");
        _setValue(_textbox("user"), $username);
        _setPassword(_password("password"), $password);
        _click(_submit("Login"));
    }
    addBooks($qJava:string, $qRuby:string, $qPython:string) {
        _setValue(_textbox("q"), $qJava);
        _setValue(_textbox("q[1]"), $qRuby);
        _setValue(_textbox("q[2]"), $qPython);
        _click(_button("Add"));
    }
    logout(){
        _click(_button("Logout"));
    }
    doAll() {
        this.login("test", "MgkKEQBU");
        this.addBooks("2", "3", "1");
        this.verifyTotal(1550);
        this.logout();
    }

}
 