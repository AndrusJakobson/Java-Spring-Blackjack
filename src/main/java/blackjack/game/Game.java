package blackjack.game;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import blackjack.cardManager.CardDealer;
import blackjack.cardManager.Player;

@Controller
@RequestMapping("/")
public class Game {
	Player player;
	CardDealer cardDealer;
	
	@GetMapping
	public String getIndex(Model model) {
		initGame();
		model.addAttribute("playerHand", player.getPlayerHand());
		model.addAttribute("handWorth", player.getHandWorth());
		return "index";
	}
	
	private void initGame() {
		cardDealer = new CardDealer();
		player = new Player();
		player.addCards(cardDealer.drawStartingHand());
		//TODO dealer draw cards
	}
}
