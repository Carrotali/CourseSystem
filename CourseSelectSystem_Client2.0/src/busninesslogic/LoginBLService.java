package busninesslogic;
/*
 * �ӿ�����LoginBLService
 * ���ܣ���½�߼���
 */
public interface LoginBLService {
	Boolean isLogin(String role,String id,String password);
	Boolean register(String role,String id,String name,String password,String institute);
}
