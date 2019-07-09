package blackjack.game;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		model.addAttribute("dealerHand", dealer.getPlayerHand());
		return "index";
	}
	
	@PostMapping("addCard")
	public String handlePostCommand(Model model) {
		gambler.addCard(cardManager.getCard());
		
		if(gambler.isOverMaxValue()) {
			return "fragments/loss";
		}
		
		model.addAttribute("gamblerHand", gambler.getPlayerHand());
		return "fragments/hand";
	}
	
	private void initGame() {
		cardManager = new CardManager();
		gambler = new Gambler();
		dealer = new Dealer();
		gambler.addCards(cardManager.drawStartingHand());
		dealer.addCard(cardManager.getCard());
	}
}
