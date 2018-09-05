package nyc.bbah.mvp_retro.main_activity;

import android.util.Log;

import nyc.bbah.mvp_retro.model.NoticeList;
import nyc.bbah.mvp_retro.my_interface.GetNoticeDataService;
import nyc.bbah.mvp_retro.network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetNoticeInteractorImpl implements MainContract.GetNoticeInteractor {


    @Override
    public void getNoticeArrayList(final OnFinishedListener onFinishedListener) {
        //Create handle for the RetrofitInstance interface
        GetNoticeDataService service = RetrofitInstance.getRetrofitInstance().create(GetNoticeDataService.class);

        // Call the method with parameter in the interface to get the notice data
        Call<NoticeList> call = service.getNoticeData();

        //Log the URL called
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {
                onFinishedListener.onFinished(response.body().getNoticeArrayList());
            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}