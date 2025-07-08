package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("SELECT sysdate FROM dual")	// ; 없이 sql문을 넣는다.
	public String getTime();
	
	public String getTime2();	// 메서드가 호출되면 mybatis에서 xml을 찾는다. src/main/resources/org/zerock/mapper/TimeMapper.xml
}
