package busninesslogic;
/*
 * 接口名：LoginBLService
 * 功能：登陆逻辑层
 */
public interface LoginBLService {
	Boolean isLogin(String role,String id,String password);
	Boolean register(String role,String id,String name,String password,String institute);
}
