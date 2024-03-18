package engine;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners implements ITestListener {


    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " succeeded");
    }


    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " failed");
    }
}
