package °­¼®È£;

import java.util.*;

public class ProgTest2 {
	Map<String,MemberData> mapList = new Hashtable<>();
	
	void mapListAdd(String memberID, String name, String tel, String gender) {
		mapList.put(memberID, new MemberData(memberID, name, tel, gender));
	   }
	   
	   void mapListRemove(String memberID) {
	      mapList.remove(memberID.trim());
	   }
	   
	   ArrayList<MemberData> getMapList() {
	      ArrayList<MemberData> array = new ArrayList<>();
	      Set<String> keyset = mapList.keySet();
	      Iterator<String> keyiterator = keyset.iterator();
	      while(keyiterator.hasNext()) {
	         String k = keyiterator.next();
	         MemberData v = mapList.get(k);
	         array.add(v);
	      }
		return array;
	      
	   }
	
	}


