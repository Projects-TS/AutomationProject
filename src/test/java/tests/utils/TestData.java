package tests.utils;

import org.testng.annotations.Test;

public class TestData {
    @Test(dataProvider = "LoginDataProvider", dataProviderClass = TestUtils.class)
    public void testLogin(String username, String password){

    }
}
