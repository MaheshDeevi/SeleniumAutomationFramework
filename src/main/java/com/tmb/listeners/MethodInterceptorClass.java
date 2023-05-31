package com.tmb.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.tmb.utils.ExcelUtils;

public class MethodInterceptorClass implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		
		List<IMethodInstance> result = new ArrayList<>();
		List<Map<String, String>> list = ExcelUtils.getTestDetails("RUNMANAGER");
		
		for(int i=0;i<methods.size();i++) {
			for(int j=0;j<list.size();j++) {
				
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("TestName"))
						&& list.get(j).get("execute").equalsIgnoreCase("yes")) {
					
						result.add(methods.get(i));
					
				}
			}
		}
		
		return result;
	}

}
