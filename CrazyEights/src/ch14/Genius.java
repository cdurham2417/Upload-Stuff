package ch14;

public class Genius extends Player {
	public Genius(String name) {
		super(name);
	}

	@Override
	public Card searchForMatch(Card prev) {
		if (searchForSuit(prev, false) != null)
			return searchForSuit(prev, true);
		if (searchForRank(prev, false) != null)
			return searchForRank(prev, true);
		if (searchForEight(false) != null)
			return this.searchForEight(true);
		else
			return null;

	}

	private Card searchForEight(boolean removeCard) {
		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.getCard(i);
			if (card.getRank() == 8)
				if (removeCard)
					return hand.popCard(i);
				else
					return hand.getCard(i);
		}
		return null;
	}

	public Card searchForRank(Card prev, boolean removeCard) {
		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.getCard(i);
			if (card.getRank() != 8 && card.getRank() == prev.getRank())
				if (removeCard)
					return hand.popCard(i);
				else
					return hand.getCard(i);
		}
		return null;
	}

	public Card searchForSuit(Card prev, boolean removeCard) {
		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.getCard(i);
			if (card.getSuit() == prev.getSuit() && card.getRank() != 8)
				if (removeCard)
					return hand.popCard(i);
				else
					return hand.getCard(i);
		}
		return null;
	}
}