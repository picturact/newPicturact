package com.project.picturact.article.service;

import java.io.IOException;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.project.picturact.article.dao.ArticleDao;
import com.project.picturact.component.dto.ArticleInfo;
import com.project.picturact.component.dto.ImageInfo;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Inject
	ArticleDao articleDao;
	
	@Resource(name="saveDir")
	String saveDir;

	@Override
	public void postArticle(String userId, String content, MultipartHttpServletRequest postImgs) throws IOException, Exception {
		// TODO Auto-generated method stub

		int nextArticleNum = articleDao.getNextArticleNum();
		ImageInfo imgInfo;
		ArticleInfo article = new ArticleInfo();
		article.setUserId(userId);
		article.setArticleNum(nextArticleNum);
		article.setContent(content);
		article.setHowManyFiles(postImgs.getFiles("postImgs").size());
		articleDao.insertArticle(article);

		
		for(MultipartFile file:postImgs.getFiles("postImgs")){
			imgInfo = new ImageInfo();
			String storedFname = UploadFileUtils.uploadFile(saveDir, file.getOriginalFilename(), file.getBytes());
			imgInfo.setArticleNum(nextArticleNum);
			imgInfo.setStoredFname(storedFname);
			imgInfo.setFileLength(file.getSize());
			articleDao.insertImgInfo(imgInfo);
		}
		
		
		
		
		
	}
	
	
	
	

}
