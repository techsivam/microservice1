import org.springframework.cloud.contract.spec.Contract


Contract.make {
  request {
    method 'GET'
    url '/contentMetadata/group?id=id10'
  }
response {
  status 200
    body(assetId:$(consumer('id10'), producer(execute('comapreTextOutput($it,"id10")'))),
    responseObject:$(consumer('123456'), producer(execute('isProperCorrelationId($it)')))
    )
	headers {
	    header('Content-Type': 'application/json;charset=UTF-8')
	  }
	 
 }
}