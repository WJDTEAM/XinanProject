package tqm.bianfeng.com.xinanproject.network.api;

import retrofit2.http.GET;
import rx.Observable;
import tqm.bianfeng.com.xinanproject.pojo.ZTResult;

/**
 * Created by johe on 2017/4/24.
 */

public interface ZTService {

    //最新小时数据
    /*
    {
  "success": true,
  "code": null,
  "message": null,
  "data": {
    "list": [
      {
        "TIME": "2017-05-10 14:00:00",
        "VALUE": 8,
        "TYPE": "SO2",
        "NUM": 1
      },
      {
        "TIME": "2017-05-10 14:00:00",
        "VALUE": 2,
        "TYPE": "NO2",
        "NUM": 2
      },
      {
        "TIME": "2017-05-10 14:00:00",
        "VALUE": 0.439,
        "TYPE": "CO",
        "NUM": 3
      },
      {
        "TIME": "2017-05-10 14:00:00",
        "VALUE": 40,
        "TYPE": "O3",
        "NUM": 4
      },
      {
        "TIME": "2017-05-10 14:00:00",
        "VALUE": 67,
        "TYPE": "PM10",
        "NUM": 5
      },
      {
        "TIME": "2017-05-10 14:00:00",
        "VALUE": 8,
        "TYPE": "PM25",
        "NUM": 6
      },
      {
        "TIME": "2017-05-10 14:00:00",
        "VALUE": 59,
        "TYPE": "AQI",
        "NUM": 7
      }
    ]
  }
}
     */
    @GET("{appCode:\"xinanzz\",serviceCode:\"airhour\"}")
    Observable<ZTResult> getPMairhour();
    //最新实时数据
    /*
{
  "success": true,
  "code": null,
  "message": null,
  "data": {
    "list": [
      {
        "TIME": "2017-05-10 14:30:00",
        "VALUE": 10,
        "TYPE": "SO2",
        "NUM": 1
      },
      {
        "TIME": "2017-05-10 14:30:00",
        "VALUE": 1,
        "TYPE": "NO2",
        "NUM": 2
      },
      {
        "TIME": "2017-05-10 14:30:00",
        "VALUE": 0.542,
        "TYPE": "CO",
        "NUM": 3
      },
      {
        "TIME": "2017-05-10 14:30:00",
        "VALUE": 44,
        "TYPE": "O3",
        "NUM": 4
      },
      {
        "TIME": "2017-05-10 14:30:00",
        "VALUE": 72,
        "TYPE": "PM10",
        "NUM": 5
      },
      {
        "TIME": "2017-05-10 14:30:00",
        "VALUE": 7,
        "TYPE": "PM25",
        "NUM": 6
      },
      {
        "TIME": "2017-05-10 14:30:00",
        "VALUE": 61,
        "TYPE": "AQI",
        "NUM": 7
      }
    ]
  }
}
     */
    @GET("{appCode:\"xinanzz\",serviceCode:\"airreal\"}")
    Observable<ZTResult> getPMairreal();
    //最新日报数据
    /*
    {
  "success": true,
  "code": null,
  "message": null,
  "data": {
    "list": [
      {
        "TIME": "2017-05-10 14:00:00",
        "VALUE": 8,
        "TYPE": "SO2",
        "NUM": 1
      },
      {
        "TIME": "2017-05-10 14:00:00",
        "VALUE": 2,
        "TYPE": "NO2",
        "NUM": 2
      },
      {
        "TIME": "2017-05-10 14:00:00",
        "VALUE": 0.439,
        "TYPE": "CO",
        "NUM": 3
      },
      {
        "TIME": "2017-05-10 14:00:00",
        "VALUE": 40,
        "TYPE": "O3",
        "NUM": 4
      },
      {
        "TIME": "2017-05-10 14:00:00",
        "VALUE": 67,
        "TYPE": "PM10",
        "NUM": 5
      },
      {
        "TIME": "2017-05-10 14:00:00",
        "VALUE": 8,
        "TYPE": "PM25",
        "NUM": 6
      },
      {
        "TIME": "2017-05-10 14:00:00",
        "VALUE": 59,
        "TYPE": "AQI",
        "NUM": 7
      }
    ]
  }
}
     */
    @GET("{appCode:\"xinanzz\",serviceCode:\"airday\"}")
    Observable<ZTResult> getPMairday();

}
