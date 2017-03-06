package edu.fjnu.fujiantravel.push;

import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.AddDevicesToTagRequest;
import com.baidu.yun.push.model.AddDevicesToTagResponse;
import com.baidu.yun.push.model.CreateTagRequest;
import com.baidu.yun.push.model.CreateTagResponse;
import com.baidu.yun.push.model.DeleteDevicesFromTagRequest;
import com.baidu.yun.push.model.DeleteDevicesFromTagResponse;
import com.baidu.yun.push.model.DeleteTagRequest;
import com.baidu.yun.push.model.DeleteTagResponse;
import com.baidu.yun.push.model.PushBatchUniMsgRequest;
import com.baidu.yun.push.model.PushBatchUniMsgResponse;
import com.baidu.yun.push.model.PushMsgToAllRequest;
import com.baidu.yun.push.model.PushMsgToAllResponse;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;
import com.baidu.yun.push.model.PushMsgToSmartTagRequest;
import com.baidu.yun.push.model.PushMsgToSmartTagResponse;
import com.baidu.yun.push.model.PushMsgToTagRequest;
import com.baidu.yun.push.model.PushMsgToTagResponse;
import com.baidu.yun.push.model.QueryDeviceNumInTagRequest;
import com.baidu.yun.push.model.QueryDeviceNumInTagResponse;
import com.baidu.yun.push.model.QueryMsgStatusRequest;
import com.baidu.yun.push.model.QueryMsgStatusResponse;
import com.baidu.yun.push.model.QueryStatisticDeviceRequest;
import com.baidu.yun.push.model.QueryStatisticDeviceResponse;
import com.baidu.yun.push.model.QueryStatisticTopicRequest;
import com.baidu.yun.push.model.QueryStatisticTopicResponse;
import com.baidu.yun.push.model.QueryTagsRequest;
import com.baidu.yun.push.model.QueryTagsResponse;
import com.baidu.yun.push.model.QueryTimerListRequest;
import com.baidu.yun.push.model.QueryTimerListResponse;
import com.baidu.yun.push.model.QueryTimerRecordsRequest;
import com.baidu.yun.push.model.QueryTimerRecordsResponse;
import com.baidu.yun.push.model.QueryTopicListRequest;
import com.baidu.yun.push.model.QueryTopicListResponse;
import com.baidu.yun.push.model.QueryTopicRecordsRequest;
import com.baidu.yun.push.model.QueryTopicRecordsResponse;

public class Push {
	private static final Push PUSH = new Push();
	private final String API_KEY = "Q69dAFgCVtG1X37GdRgYQi1NglfX2bkx";
	private final String SECRET_KEY = "Ikt9vIiqXeNIwifsBmjwucBrjGoMeyPi";
	private PushKeyPair pair;
	private BaiduPushClient pushClient;

	private Push() {
		pair = new PushKeyPair(API_KEY, SECRET_KEY);
		pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);
	}

	public static Push getIstance() {
		return PUSH;
	}

	public void PushMsgToAll(PushMsgToAllRequest request) throws PushClientException, PushServerException {
		PushMsgToAllResponse response = pushClient.pushMsgToAll(request);
	}

	public void PushMsgToSingleDevice(PushMsgToSingleDeviceRequest request)
			throws PushClientException, PushServerException {
		PushMsgToSingleDeviceResponse response = pushClient.pushMsgToSingleDevice(request);
	}

	public void PushMsgToTag(PushMsgToTagRequest request) throws PushClientException, PushServerException {
		PushMsgToTagResponse response = pushClient.pushMsgToTag(request);
	}

	public void PushMsgToSmartTag(PushMsgToSmartTagRequest request) throws PushClientException, PushServerException {
		PushMsgToSmartTagResponse response = pushClient.pushMsgToSmartTag(request);
	}

	public void PushBatchUniMsg(PushBatchUniMsgRequest request) throws PushClientException, PushServerException {
		PushBatchUniMsgResponse response = pushClient.pushBatchUniMsg(request);
	}

	public void QueryMsgStatus(QueryMsgStatusRequest request) throws PushClientException, PushServerException {
		QueryMsgStatusResponse response = pushClient.queryMsgStatus(request);
	}

	public void QueryTimerRecords(QueryTimerRecordsRequest request) throws PushClientException, PushServerException {
		QueryTimerRecordsResponse response = pushClient.queryTimerRecords(request);
	}

	public void QueryTopicRecords(QueryTopicRecordsRequest request) throws PushClientException, PushServerException {
		QueryTopicRecordsResponse response = pushClient.queryTopicRecords(request);
	}

	public void QueryTimerList(QueryTimerListRequest request) throws PushClientException, PushServerException {
		QueryTimerListResponse response = pushClient.queryTimerList(request);
	}

	public void QueryTopicList(QueryTopicListRequest request) throws PushClientException, PushServerException {
		QueryTopicListResponse response = pushClient.queryTopicList(request);
	}

	public void QueryTags(QueryTagsRequest request) throws PushClientException, PushServerException {
		QueryTagsResponse response = pushClient.queryTags(request);
	}

	public void CreateTag(CreateTagRequest request) throws PushClientException, PushServerException {
		CreateTagResponse response = pushClient.createTag(request);
	}

	public void DeleteTag(DeleteTagRequest request) throws PushClientException, PushServerException {
		DeleteTagResponse response = pushClient.deleteTag(request);
	}

	public void AddDevicesToTag(AddDevicesToTagRequest request) throws PushClientException, PushServerException {
		AddDevicesToTagResponse response = pushClient.addDevicesToTag(request);
	}

	public void DeleteDevicesFromTag(DeleteDevicesFromTagRequest request)
			throws PushClientException, PushServerException {
		DeleteDevicesFromTagResponse response = pushClient.deleteDevicesFromTag(request);
	}

	public void QueryDeviceNumInTag(QueryDeviceNumInTagRequest request)
			throws PushClientException, PushServerException {
		QueryDeviceNumInTagResponse response = pushClient.queryDeviceNumInTag(request);
	}

	public void QueryStatisticTopic(QueryStatisticTopicRequest request)
			throws PushClientException, PushServerException {
		QueryStatisticTopicResponse response = pushClient.queryStatisticTopic(request);
	}

	public void QueryStatisticDevice(QueryStatisticDeviceRequest request)
			throws PushClientException, PushServerException {
		QueryStatisticDeviceResponse response = pushClient.queryStatisticDevice(request);
	}
}
