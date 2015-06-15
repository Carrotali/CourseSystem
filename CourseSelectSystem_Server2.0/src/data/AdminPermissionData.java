package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * ������AdminPermissionData 
 * ���ܣ�ʵ��AdminPermissionDataService�ӿ�
 * 
 */

public class AdminPermissionData extends UnicastRemoteObject implements AdminPermissionDataService{

	public AdminPermissionData() throws RemoteException {};

         /*
	 * ��������setPermission
	 * ���ܣ����ò��ԡ��ƻ���ѡ�Ρ���ѡ��ִ����
	 * (non-Javadoc)
	 * @see busninesslogic.AdminBLService#checkSchoolTeacherInfor()
	 */

	public void setPermission(int type,String yesOrno) {
		// TODO Auto-generated method stub
		//permission˳��Ϊ   ���ԣ��ƻ���ѡ�Σ���ѡ��
		File adminPermission = new File("adminPermission");
		String permission = null;
		String[] permissionType = new String[4];
		try {
		BufferedReader reader=new BufferedReader(new FileReader(adminPermission));
		String line=null;
		while((line=reader.readLine())!=null){
			permission = line;
        }		
		} catch (FileNotFoundException e1) {
		System.out.println("No file found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0;i < 4;i++){
			permissionType[i] = permission.split(";")[i];
		}
		if(type == 0){
			permissionType[0] = yesOrno;
		}else if(type == 1){
			permissionType[1] = yesOrno;
		}else if(type == 2){
			permissionType[2] = yesOrno;
		}else{
			permissionType[3] = yesOrno;
		}
		permission = permissionType[0] + ";" + permissionType[1] + ";" + permissionType[2] + ";" + permissionType[3];
		
		FileWriter fw = null;
		try {
			fw = new FileWriter("adminPermission");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			fw.write(permission);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���ļ�д��		
		try {
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/*
	 * ��������getPermission
	 * ���ܣ��õ����ԡ��ƻ���ѡ�Ρ���ѡ��ִ����
	 * (non-Javadoc)
	 * @see busninesslogic.AdminBLService#getAbletoChangePolicy()
	 * @see busninesslogic.AdminBLService#getAbletoChangePlan()
	 * @see busninesslogic.AdminBLService#getAbletoSelectCourse()
	 * @see busninesslogic.AdminBLService#getAbletoReselectCourse()
	 */
	
	@Override
	public int getPermission(int type) {
		//permission˳��Ϊ   ���ԣ��ƻ���ѡ�Σ���ѡ��
				File adminPermission = new File("adminPermission");
				String permission = null;
				String[] permissionType = new String[4];
				String Permission = null;
				try {
				BufferedReader reader=new BufferedReader(new FileReader(adminPermission));
				String line=null;
				while((line=reader.readLine())!=null){
					permission = line;
		        }		
				} catch (FileNotFoundException e1) {
				System.out.println("No file found");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(permission);
				for(int i = 0;i < 4;i++){
					permissionType[i] = permission.split(";")[i];
				}
				if(type == 0){
					Permission = permissionType[0];
				}else if(type == 1){
					Permission = permissionType[1];
				}else if(type == 2){
					Permission = permissionType[2];
				}else{
					Permission = permissionType[3];
				}
		
		return Integer.valueOf(Permission).intValue();

		
	}
	
    

}

