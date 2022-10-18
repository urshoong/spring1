package org.zerock.spring1.controller;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.spring1.dto.UploadResultDTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
public class UploadController {

    @GetMapping("/display")
    public byte[] down(String name){
        File file = new File("C:\\upload\\" + name);

        try {
            byte[] result = FileCopyUtils.copyToByteArray(file);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/upload")
    public List<UploadResultDTO> uploadAjax(MultipartFile[] files){

        log.info(files);

        List<UploadResultDTO> result = new ArrayList<>();

        //실제 파일 업로드 구현부
        if(files != null && files.length > 0){
            for (int i = 0; i < files.length; i++) {

                MultipartFile file = files[i];

                log.info(file.getOriginalFilename());

                //중복된 파일 업로드 시 파일이 덮어쓰기 되는것을 방지하기 위하여 UUID를 사용한다
                UUID uuid = UUID.randomUUID();

                String saveName = uuid.toString() + "_" + file.getOriginalFilename();

                File saveFile = new File("C:\\upload", saveName);

                try {
                    file.transferTo(saveFile);

                    //MIME TYPE이 image인 파일
                    if(file.getContentType().startsWith("image")){
                        String thumbName = "s_" + saveName;
                        File thumbFile = new File("C:\\upload", thumbName);
                        //inFile, outFile, width, height
                        Thumbnailator.createThumbnail(saveFile, thumbFile, 200, 200);

                        result.add(UploadResultDTO.builder().fileName(file.getOriginalFilename()).uuid(uuid.toString()).image(true).build());
                    }else{
                        result.add(UploadResultDTO.builder().fileName(file.getOriginalFilename()).uuid(uuid.toString()).build());
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }//end for
        }//end if

        //배열로 반환하면 JSON으로 처리되지만 기본자료형이나 문자열로 반환하면 문자열로 처리된다
        return result;
    }

}
