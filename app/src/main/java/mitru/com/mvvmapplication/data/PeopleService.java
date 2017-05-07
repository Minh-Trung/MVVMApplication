package mitru.com.mvvmapplication.data;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by ctruong on 07/05/2017.
 */

public interface PeopleService {
    @GET
    Observable<PeopleResponse> fetchPeople(@Url String url);
}
