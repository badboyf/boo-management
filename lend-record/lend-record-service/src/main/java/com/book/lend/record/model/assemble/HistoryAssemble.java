package com.book.lend.record.model.assemble;

import java.util.ArrayList;
import java.util.List;

import com.book.lend.record.dto.HistoryDTO;
import com.book.lend.record.model.vo.History;

public class HistoryAssemble {
	public static List<HistoryDTO> assemble(List<History> histories) {
		List<HistoryDTO> historyDTOs = new ArrayList<HistoryDTO>();
		for (History history : histories) {
			historyDTOs.add(assemble(history));
		}

		return historyDTOs;
	}

	public static HistoryDTO assemble(History history) {
		HistoryDTO historyDTO = new HistoryDTO();
		historyDTO.setDate(history.getDate());
		historyDTO.setStatus(history.getStatus());

		return historyDTO;
	}
}
