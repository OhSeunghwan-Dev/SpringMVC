package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {

	private List<SampleDTO> list;	// dto 객체를 갖고 있는 리스트
	
	// 생성자
	public SampleDTOList() {
		list = new ArrayList<SampleDTO>();
	}
	// new SampleDTOList() -> 리스트에 dto를 갖고 있는 객체 생성된다.
}
