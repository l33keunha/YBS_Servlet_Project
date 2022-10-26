package util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File f) {
		
		//현재 시간 가져옴
		long currentTime = System.currentTimeMillis();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		
		//확장자 떼기
		String name = f.getName();
		String ext = null;
		int count = 0;
		
		int dot = name.lastIndexOf(".");
		if(dot == -1) {
			ext = "";
		} else {
			ext = name.substring(dot);
		}
		
		String fileName = null;
		File[] files = f.listFiles(File::isFile);
		long lastModifiedTime = Long.MIN_VALUE;
		
		//파일명변경 (최근에 수정된 파일 있/없 나눠서)
		if(files != null)
		{
			for(File file : files) 
			{
				if(file.lastModified() > lastModifiedTime) //최근에 수정된 파일 있으면
				{
					fileName = f.getName(); //파일명 가져와서
					count++;
					fileName = fileName.substring(0, dot) + count + ext ; //기존의 파일명에 count
			
				} else { //최근에 수정된 파일 없으면
					count++;
					fileName = sdf.format(new Date(currentTime)) + "_" + count + ext; //파일명에 날짜+언더바+카운트+확장자
				}
			}
		}
		
		System.out.println(fileName);
		File newFile = new File(f.getParent(), fileName); //f 최상위 디렉토리에 새로운 파일 생성
		
		return newFile;
	}
	
	
}
