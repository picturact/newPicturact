package com.project.picturact.component.service;

import java.util.ArrayList;

import com.project.picturact.component.dto.ArticleInfo;

public interface ComponentService {

	public ArrayList<ArticleInfo> getMainArticle(String userId);

	public ArrayList<ArticleInfo> getPersonalArticle(String userId);

	public ArrayList<String> getFollowList(String userId);

	public int getFollowState(String pageId, String userId);

}
