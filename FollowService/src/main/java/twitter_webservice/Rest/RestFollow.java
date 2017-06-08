package twitter_webservice.Rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import twitter_webservice.domain.Userr;
import twitter_webservice.service.TweetMgr;
import twitter_webservice.service.UserMgr;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Anna-May on 16/03/2017.
 */
@Path("/RestServiceFollow")
@ApplicationPath("/resources")
@Stateless
public class RestFollow extends Application {
    @Inject
    TweetMgr tweetMgr;

    @Inject
    UserMgr userMgr;

    @GET
    @Path("/getCountFollowing/{id}") // check
    @Produces(MediaType.APPLICATION_JSON)
    public String getCountFollowing(@PathParam("id") Long id) {
        int count = userMgr.getCountFollowing(id);
        String result = null;
        try {
            result = new ObjectMapper().writeValueAsString(count);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GET
    @Path("/getCountFollower/{id}") // check
    @Produces(MediaType.APPLICATION_JSON)
    public String getCountFollower(@PathParam("id") Long id) {
        int count = userMgr.getCountFollower(id);
        String result = null;
        try {
            result = new ObjectMapper().writeValueAsString(count);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GET
    @Path("/getFollowers/{username}") //check
    @Produces(MediaType.APPLICATION_JSON)
    public String getFollowers(@PathParam("username") String username) {
        List<Userr> users = userMgr.getFollowers(username);
        String result = null;
        try {
            result = new ObjectMapper().writeValueAsString(users);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GET
    @Path("/getFollowing/{username}") //check
    @Produces(MediaType.APPLICATION_JSON)
    public String getFollowing(@PathParam("username") String username) {
        List<Userr> users = userMgr.getFollowing(username);
        String result = null;
        try {
            result = new ObjectMapper().writeValueAsString(users);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}

