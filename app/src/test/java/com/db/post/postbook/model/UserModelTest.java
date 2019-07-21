package com.db.post.postbook.model;

import com.db.post.postbook.restServices.User;
import com.db.post.postbook.restServices.UserComment;
import com.db.post.postbook.restServices.UserPost;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserModelTest {

    private static final String USER_ID = "user30685";
    private static final String USER_NAME = "User1";
    private static final String POST_ID = "post12345";
    private static final String POST_TITLE = "SomeTitle";
    private static final String POST_TEXT = "post text";
    private static final boolean IS_FAV = false;
    private static final String COMMENT_ID = "comment12345";
    private static final String USER_COMMENT_TEXT = "SomeComment";
    private static final String COMMENT_WRITER = "User2";
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


    private UserModel userModel;
    private UserPost userPost;

    @Before
    public void before() {
        userModel = new UserModel();
        User orignalUserData = getUserWithOrignalData();

        userPost = orignalUserData.getUserPostList().get(0);
        userModel.setCurrentUser(orignalUserData);
        userModel.setCurrentPost(userPost);

    }

    @Test
    public void testGetFavPost(){

        List<UserPost> userPosts = userModel.getFavPosts();

        assertThat(userPosts.size(),is(0));

        userModel.updatePostLikeness(userModel.getCurrentUser().getUserPostList().get(0));

        userPosts = userModel.getFavPosts();
        assertThat(userPosts.size(),is(1));

    }



    @Test
    public void testUserFavPostUpdatesAfterChangingTheFavStatus(){

        List<UserPost> userPosts = userModel.getFavPosts();

        assertThat(userPosts.size(),is(0));

        userModel.updatePostLikeness(userModel.getCurrentUser().getUserPostList().get(0));

        userPosts = userModel.getFavPosts();
        assertThat(userPosts.size(),is(1));

    }



    private User getUserWithOrignalData() {
        return new User(USER_ID, USER_NAME, getUserPosts());

    }

    private List<UserPost> getUserPosts() {

        List<UserPost> userPostList = new ArrayList<>();

        UserPost userPost = new UserPost(POST_ID, POST_TITLE, POST_TEXT, IS_FAV, getPostCommentList());


        userPostList.add(userPost);
        return userPostList;
    }

    private List<UserComment> getPostCommentList() {

     List<UserComment> userCommentList = new ArrayList<>();

     UserComment  userComment = new UserComment(COMMENT_ID, USER_COMMENT_TEXT, COMMENT_WRITER);
     userCommentList.add(userComment);

     return userCommentList;

    }


}
