package software.ulpgc.kata5.io;

import com.google.gson.Gson;
import software.ulpgc.kata5.io.pojos.RandomUserGetResponse;

public class RandomUserDeserializer implements UserDeserializer {
    @Override
    public Object deserialize(String read) {
        return new Gson().fromJson(read, RandomUserGetResponse.class);
    }
}
