package service.bean;

import lombok.Data;

@Data
public class BoardPaging {
	private int currentPage; // 현재페이지
	private int pageBlock; // [이전][1][2][3][다음]
	private int pageSize; // 1페이지당 5개씩
	private int totalA; // 총글수
	private StringBuffer pagingHTML;

	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
		
		int totalP = (int)(totalA+(pageSize-1))/pageSize; //총페이지수=(총글수+4)/5
		
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		
		if(endPage > totalP) {
			endPage = totalP;
		}
		// [이전]
		if(startPage > pageBlock)
			pagingHTML.append("[<a id='paging' href='serviceBoardList.do?pg="+(startPage-1)+"'>이전</a>]");
		
		for(int i = startPage; i<=endPage; i++) {
			if(i == currentPage) 
				pagingHTML.append("[<a id='currentPaging' href='serviceBoardList.do?pg="+i+"'>"+i+"</a>]");
			else
				pagingHTML.append("[<a id='paging' href='serviceBoardList.do?pg="+i+"'>"+i+"</a>]");
		} 
		// [다음]
		if(endPage < totalP)
			pagingHTML.append("[<a id='paging' href='serviceBoardList.do?pg="+(endPage+1)+"'>다음</a>]");
	}
	
	public void makeSearchPagingHTML() {
		pagingHTML = new StringBuffer();
		
		int totalP = (int)(totalA+(pageSize-1))/pageSize; 
		
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		
		if(endPage > totalP) {
			endPage = totalP;
		}
		
		if(startPage>pageBlock)
			pagingHTML.append("[<span id='paging' onclick='boardSearch("+(startPage-1)+")'>이전</span>]");                                             
				
		for(int i=startPage; i<=endPage; i++) {
			if(i==currentPage)
				pagingHTML.append("[<span id='currentPaging' onclick='boardSearch("+i+")'>"+i+"</span>]");
			else
				pagingHTML.append("[<span id='paging' onclick='boardSearch("+i+")'>"+i+"</span>]");
		}
		
		if(endPage < totalP)
			pagingHTML.append("[<span id='paging' onclick='boardSearch("+(endPage+1)+")'>다음</span>]");
	}
}
