package com.example.gads_2020.Service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

        private static final String URL = "https://gadsapi.herokuapp.com/";
        private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create());

        // Create logger
        private static HttpLoggingInterceptor logger =
                new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

        // Create OkHttp Client
        private static OkHttpClient.Builder okHttp =
                new OkHttpClient.Builder().addInterceptor(logger);

        private static Retrofit retrofit = builder.build();

        //helper class to assist in building services
        public static <S> S buildService(Class<S> serviceType) {
                return retrofit.create(serviceType);
        }

        private final static String SEND_URL = "https://docs.google.com/forms/d/e/";
        private static Retrofit.Builder build = new Retrofit.Builder().baseUrl(SEND_URL)
                .addConverterFactory(GsonConverterFactory.create());

        private static Retrofit retrofit2  = builder.build();

        public <P> P buildServices(Class<P> endpoint) {
                return retrofit.create(endpoint);
        }

}
