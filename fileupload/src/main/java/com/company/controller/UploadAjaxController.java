package com.company.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.company.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import oracle.net.aso.f;

@Log4j2
@Controller
public class UploadAjaxController {

	@PostMapping("/uploadAjax")
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile){
		
		//서버 폴더에 첨부 파일 저장
		String uploadFoler= "e:\\upload";
		
		String uploadFileName = "";
		
		//첨부파일 목록 리스트 생성
		List<AttachFileDTO> attachList = new ArrayList<AttachFileDTO>();
		
		//upload 폴더 결정
		String uploadFolderPath = getFolder();
		File uploadPath = new File(uploadFoler,uploadFolderPath);
		
		//디렉토리 생성
		if(!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		
		for(MultipartFile multipartFile : uploadFile) {
			log.info("ajax upload" + multipartFile.getOriginalFilename());
			
			//uuid 값 파일에 추가하기
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString()+"_"+multipartFile.getOriginalFilename();
			
			File saveFile = new File(uploadPath, uploadFileName);
			
			AttachFileDTO attachFileDTO = new AttachFileDTO();
			attachFileDTO.setUuid(uuid.toString());
			attachFileDTO.setUploadPath(uploadFolderPath);
			attachFileDTO.setFileName(multipartFile.getOriginalFilename());
			
			
			//이미지 파일 여부 확인
			if(checkImageType(saveFile)) {
				attachFileDTO.setFileType(true);
				
				//썸네일 저장
				try {
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,"s "+uploadFileName));
					InputStream in = multipartFile.getInputStream();
					Thumbnailator.createThumbnail(in, thumbnail,100,100);
					in.close();
					thumbnail.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			attachList.add(attachFileDTO);
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return new ResponseEntity<List<AttachFileDTO>>(attachList,HttpStatus.OK);
	}
	
	//이미지 파일 여부 확인
	private boolean checkImageType(File file) {
		String contentType;
		
		try {
			contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//폴더명 생성
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();// Wed Dec 14:54:10 KST 2021
		String str =  sdf.format(date); //	"2021-12-08"
		
		//	windows : \, unix : /
		return str.replace("-",File.separator);	// 2021/12/08
	}
}
