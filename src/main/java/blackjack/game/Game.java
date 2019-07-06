package blackjack.game;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import blackjack.cardManager.CardManager;
import blackjack.cardManager.Dealer;
import blackjack.cardManager.Player;
import blackjack.cardManager.Gambler;

@Controller
@RequestMapping("/")
public class Game {
	Player gambler;
	Player dealer;
	CardManager cardManager;
	
	@GetMapping
	public String getIndex(Model model) {
		initGame();
		model.addAttribute("gamblerHand", gambler.getPlayerHand());
		model.addAttribute("gamblerValue", gambler.getHandValue());
		model.addAttribute("dealerHand", dealer.getPlayerHand());
		model.addAttribute("dealerValue", dealer.getHandValue());
		
		return "index";
	}
	
	private void initGame() {
		cardManager = new CardManager();
		gambler = new Gambler();
		dealer = new Dealer();
		gambler.addCards(cardManager.drawStartingHand());
		dealer.addCard(cardManager.getCard());
	}
}
