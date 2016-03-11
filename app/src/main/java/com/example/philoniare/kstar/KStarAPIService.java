package com.example.philoniare.kstar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by philoniare on 3/10/16.
 */
public interface KStarAPIService {
    @GET("all")
    Call<List<Artist>> getArtists();
}
