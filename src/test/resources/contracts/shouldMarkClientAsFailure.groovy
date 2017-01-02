import org.springframework.cloud.contract.spec.Contract


Contract.make {
  request {
    method 'GET'
    url '/contentMetadata/content?id=id10'
  }
response {
  status 200
   body("""
	  {
	    "assetId": "id10"
	   
	  }
  """)
	headers {
	    header('Content-Type': 'application/json;charset=UTF-8')
	  }
 }
}