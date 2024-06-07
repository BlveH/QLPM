/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import controller.AccountController;
import java.util.List;
import object.Account;


public class AccountService {
    private AccountController accountController;

    public Account getByMaGiaoVien(String maGiaoVien){
        return accountController.getByMaGiaoVien(maGiaoVien);
    }
    
    public AccountService(AccountController accountController) {
        this.accountController = accountController;
    }

    public AccountService() {
        accountController= new AccountController();
    }

    public AccountController getAccountController() {
        return accountController;
    }

    public void setAccountController(AccountController accountController) {
        this.accountController = accountController;
    }
    public List<Account> getAllAccount(){
         return accountController.getAllAccount();
    }
    public void updateAccount(Account account){
        accountController.updateAccount(account);
    }
    public void deleteAccount(String magiaovien){
        accountController.deleteAccount(magiaovien);
    }
    public int addAccount(Account account){
         return accountController.addAccount(account);
    }
}
