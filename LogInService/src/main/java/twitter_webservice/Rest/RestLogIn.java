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


/**
 * Created by Anna-May on 16/03/2017.
 */

@Path("/RestServiceLogIn")
@ApplicationPath("/resources")
@Stateless
public class RestLogIn extends Application{
    @Inject
    TweetMgr tweetMgr;

    @Inject
    UserMgr userMgr;

    // test
    // http://localhost:8080/kwetterMay/resources/RestService/sayBagger
    @GET
    @Path("/sayBagger")
    public String getBagger(){
            return "Bagger!";
    }


    @GET
    @Path("/getUserByUserName/{username}") // check
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserByUserName(@PathParam("username") String username) {
        Userr userr = userMgr.getUserByUserName(username);
        String result = null;
        try {
            result = new ObjectMapper().writeValueAsString(userr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
