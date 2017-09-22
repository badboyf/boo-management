package com.book.lend.record.model.factory;

import java.util.ArrayList;
import java.util.List;

import com.book.lend.record.dto.HistoryDTO;
import com.book.lend.record.model.vo.History;

public class HistoryFactory {
	public static List<History> factory(List<HistoryDTO> historyDTOs) {
		List<History> histories = new ArrayList<History>();
		for (HistoryDTO history : historyDTOs) {
			histories.add(factory(history));
		}

		return histories;
	}

	public static History factory(HistoryDTO historyDTO) {
		History history = new History();
		history.setDate(historyDTO.getDate());
		history.setStatus(historyDTO.getStatus());

		return history;
	}
}
