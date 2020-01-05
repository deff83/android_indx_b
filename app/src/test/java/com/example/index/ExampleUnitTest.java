package com.example.index;

import com.example.index.Models.Enums.EnumIndex;
import com.example.index.Models.Shifr;
import com.example.index.repositories.ResatAPIClient;
import com.example.index.repositories.RetrofitService;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void get_OfferList() throws IOException {
        ResatAPIClient resatAPIClient = new RetrofitService().getResatAPIClient();
        String sign = new Shifr.Builder().set_zCoin(0).build().base64_shifr(EnumIndex.OFFERLIST);
        System.out.println(sign);
        /*BodyOfferList bodyOfferList = new BodyOfferList(
                new ApiContext(EnumIndex.OFFERLIST, sign),
                new Trading(0)
        );
        Response<OfferList_Responce> response = resatAPIClient.getOfferList(bodyOfferList).execute();
        ;
        System.out.println(response.body());*/
    }
}