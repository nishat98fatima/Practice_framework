package Utilitiy;

import PageObject_File.BaseClass;

public class CommonMethod {
	
	private BaseClass baseobj;

	public CommonMethod(BaseClass baseobj) throws Throwable {
		try {
			this.baseobj = baseobj;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void LaunchDriver() throws Throwable{
		try {
		baseobj.driver=driverManager.CreateWebDriver(ReadConfig.get_from_config("Browsername"));
		}
		catch(Exception e)
	{
			e.printStackTrace();
	}
		
	}
	
}
