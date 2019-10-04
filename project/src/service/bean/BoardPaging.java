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
		
		pagingHTML.append("<ul class='pagination justify-content-center'>");
		
		// [이전]
		if(startPage > pageBlock) {
			pagingHTML.append("<li class='paging-item'><a class='page-link' id='paging' href='serviceBoardList.do?pg="+(startPage-1)+"'>이전</a></li>");
			//pagingHTML.append("[<a id='paging' href='serviceBoardList.do?pg="+(startPage-1)+"'>이전</a>]");
		}
		for(int i = startPage; i<=endPage; i++) {
			if(i == currentPage) { 
				//pagingHTML.append("[<a id='currentPaging' href='serviceBoardList.do?pg="+i+"'>"+i+"</a>]");
				pagingHTML.append("<li class='paging-item'><a class='page-link' id='currentPaging' href='serviceBoardList.do?pg="+i+"'>"+i+"</a></li>");
			}
			else {
				//pagingHTML.append("[<a id='paging' href='serviceBoardList.do?pg="+i+"'>"+i+"</a>]");
				pagingHTML.append("<li class='paging-item'><a class='page-link' id='paging' href='serviceBoardList.do?pg="+i+"'>"+i+"</a></li>");
			}
		} 
		// [다음]
		if(endPage < totalP) {
			//pagingHTML.append("[<a id='paging' href='serviceBoardList.do?pg="+(endPage+1)+"'>다음</a>]");
			pagingHTML.append("<li class='paging-item'><a class='page-link' id='paging' href='serviceBoardList.do?pg="+(endPage+1)+"'>다음</a></li>");
		}
		pagingHTML.append("</ul>");
	}
	
}
