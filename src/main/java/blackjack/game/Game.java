package blackjack.game;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import blackjack.cardManager.CardGenerator;
import blackjack.cardManager.CardManagerInterface;
import blackjack.models.Card;

@Controller
@RequestMapping("/")
public class Game {
	ArrayList<Card> playerHand;
	CardManagerInterface cardManager;
	
	@GetMapping
	public String getIndex(Model model) {
		initGame();
		model.addAttribute("playerHand", playerHand);
		return "index";
	}
	
	private void initGame() {
		cardManager = new CardGenerator();
		playerHand = cardManager.getStartingHand();
	}
}
