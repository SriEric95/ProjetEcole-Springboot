package com.example.ecole;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ecole.UserRepository;
import com.example.ecole.ReponseRepository;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo", method =RequestMethod.GET) 

public class MainController {	
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private MatiereRepository matiereRepository;
	
	@Autowired
	private EtablissementRepository etablissementRepository;
	
	@Autowired
	private ClasseRepository classeRepository;
	
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private ReponseRepository reponseRepository;
	
	@Autowired
	private HistoriqueqcmRepository histoRepository;
	
	
	@RequestMapping(value = { "/classeList" }, method = RequestMethod.GET)
    public String classeList(Model model) {

      model.addAttribute("classe", classeRepository.findAll());
      return "classeList";
     
  	}
	
	@RequestMapping(value = { "/userList" }, method = RequestMethod.GET)
    public String userList(Model model) {
         model.addAttribute("user", userRepository.findAll());
        
         return "userList";
    }
	
	@GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
		
		User user = userRepository.findById((int) id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        
		userRepository.delete(user);
        
        model.addAttribute("user", userRepository.findAll());
        
        return "redirect:/demo/userList";
    }
	
	@GetMapping("/AjoutUser")
    public String showSignUpFormUser(User user, BindingResult result, Model model) {
		model.addAttribute("etablissement", etablissementRepository.findAll());
		model.addAttribute("classe", classeRepository.findAll());
		return "userForm";
    }
			
	@PostMapping("/addUser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "userForm";
        }
         
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "redirect:/demo/userList";
    }
	
	@GetMapping("/editUser/{id}")
	public String showUpdateForm1(@PathVariable("id") int id, Model model) {
	    User user = userRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	     
	    model.addAttribute("user", user);
	    model.addAttribute("etablissement", etablissementRepository.findAll());
	    return "update-userForm";
	}
	
	@PostMapping("/updateUser/{id}")
	public String updateUser(@PathVariable("id") int id, @Valid User user, BindingResult result, Model model) 
	{
	    
		if (result.hasErrors()) 
		{
	        user.setId(id);
	        return "update-userForm";
	    }
	         
	    userRepository.save(user);
	    model.addAttribute("users", userRepository.findAll());
	    
	    return "redirect:/demo/userList";
	    
	}
	
	@GetMapping("/ajoutProfesseur")
    public String showSignUpFormProf(User user, BindingResult result, Model model) {
		
		
		model.addAttribute("etablissement", etablissementRepository.findAll());
		model.addAttribute("classe", classeRepository.findAll());
		return "profForm";
    
	}
	
	@PostMapping("/addProf")
    public String addProf(@Valid User user, BindingResult result, Model model) {
		
		user.setRole("[\"ROLE_PROFESSEUR\"]");
		
        if (result.hasErrors()) {
            return "profForm";
        }
         
        userRepository.save(user);
        model.addAttribute("users", userRepository.findByRole("[\"ROLE_PROFESSEUR\"]"));
        return "redirect:/demo/professeurList";
    }
	
	@RequestMapping(value = { "/professeurList" }, method = RequestMethod.GET)
    public String professeurList(Model model) {
         
		model.addAttribute("professeur", userRepository.findByRole("[\"ROLE_PROFESSEUR\"]"));
		
		//model.addAttribute("user", userRepository.findAll());

        return "professeurList";

    }
	
	@GetMapping("/editProf/{id}")
	public String showUpdateFormProf(@PathVariable("id") int id, Model model) {
	    User user = userRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	     
	    model.addAttribute("user", user);
	    model.addAttribute("etablissement", etablissementRepository.findAll());
	    model.addAttribute("classe", classeRepository.findAll());
	    return "update-profForm";
	}
	
	@PostMapping("/updateProf/{id}")
	public String updateProf(@PathVariable("id") int id, @Valid User user, BindingResult result, Model model) 
	{
	    
		if (result.hasErrors()) 
		{
	        user.setId(id);
	        return "update-profForm";
	    }
	         
	    userRepository.save(user);
	    model.addAttribute("users", userRepository.findAll());
	    
	    return "redirect:/demo/professeurList";
	    
	}
	
	@GetMapping("/deleteProf/{id}")
    public String deleteProf(@PathVariable("id") int id, Model model) {
		
		User user = userRepository.findById((int) id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        
		userRepository.delete(user);
        
        model.addAttribute("user", userRepository.findAll());
        
        return "redirect:/demo/professeurList";
    }

	 	 
	 @RequestMapping(value = { "/matiereList" }, method = RequestMethod.GET)
	    public String matiereList(Model model) {
	         
			model.addAttribute("matiere", matiereRepository.findAll());
	        return "matiereList";
	    }
		
		@GetMapping("/deleteMatiere/{id}")
	    public String deleteMatiere(@PathVariable("id") int id, Model model) {
			
			Matiere mat = matiereRepository.findById((int) id)
	          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	        
			matiereRepository.delete(mat);
	        
	        model.addAttribute("matiere", matiereRepository.findAll());
	        
	        return "redirect:/demo/matiereList";
	    }
		
		@GetMapping("/ajoutMatiere")
	    public String showSignUpForm(Matiere mat) {
			return "matiereForm";
	    }
				
		@PostMapping("/addMatiere")
	    public String addMatiere(@Valid Matiere mat, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "matiereForm";
	        }
	         
	        matiereRepository.save(mat);
	        model.addAttribute("matiere", matiereRepository.findAll());
	        return "matiereList";
	    }
				
		@GetMapping("/editMatiere/{id}")
		public String showUpdateForm(@PathVariable("id") int id, Model model) {
		    Matiere mat = matiereRepository.findById(id)
		      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		     
		    model.addAttribute("matiere", mat);
		    return "update-matiereForm";
		}
		
		@PostMapping("/updateMatiere/{id}")
		public String updateMatiere(@PathVariable("id") int id, @Valid Matiere matiere, BindingResult result, Model model) 
		{
	    	matiere.setId_matiere(id);
			if (result.hasErrors()) 
			{
				matiere.setId_matiere(id);
		        return "update-matiereForm";
		    }
		   
		    matiereRepository.save(matiere);
		    model.addAttribute("matiere", matiereRepository.findAll());
		    
		    return "redirect:/demo/matiereList";
		
		}
		
		@GetMapping("/editEtab/{id}")
		public String showUpdateForm2(@PathVariable("id") int id, Model model) {
		    Etablissement etab = etablissementRepository.findById(id)
		      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		     
		    model.addAttribute("etablissement", etab);
		    return "update-etablissementForm";
		}
		
		@PostMapping("/updateEtab/{id}")
		public String updateUser(@PathVariable("id") int id, @Valid Etablissement etab, BindingResult result, Model model) 
		{
		    
			if (result.hasErrors()) 
			{
		        etab.setId(id);
		        return "update-etablissementForm";
		    }
		         
		    etablissementRepository.save(etab);
		    model.addAttribute("users", etablissementRepository.findAll());
		    
		    return "redirect:/demo/etablissementList";
		}
			
		@RequestMapping(value = { "/etablissementList" }, method = RequestMethod.GET)
	    public String etablissementList(Model model) {
	         
			model.addAttribute("etablissement", etablissementRepository.findAll());

	        return "etablissementList";

	    }
		
		
		
		@GetMapping("/deleteEtab/{id}")
	    public String deleteEtablissement(@PathVariable("id") int id, Model model) {
			
			Etablissement etab = etablissementRepository.findById((int) id)
	          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	        
			etablissementRepository.delete(etab);
	        
	        model.addAttribute("etablissement", etablissementRepository.findAll());
	        
	        return "redirect:/demo/etablissementList";
	    }
		
		@GetMapping("/ajoutEtab")
	    public String showSignUpForm(Etablissement etab) {
			return "etablissementForm";
	    }
		
		
		@PostMapping("/addEtablissement")
	    public String addEtablissement(@Valid Etablissement etab, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "etablissementForm";
	        }
	         
	        etablissementRepository.save(etab);
	        model.addAttribute("etablissement", etablissementRepository.findAll());
	        return "etablissementList";
	    }
	 	 
	
	
	@RequestMapping(value = { "/welcomePage" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");

        return "welcomePage";
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "loginPage";
    }
 
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
    
    @RequestMapping(value = { "/questionnaireList" }, method = RequestMethod.GET)
    public String questionnaireList(Model model) {
         
		model.addAttribute("questionnaire", questionnaireRepository.findAll());
        
		return "questionnaireList";

    }
	
	@GetMapping("/questionnaireUpdate/{id}")
    public String showUpdateFormQuestionnaire(@PathVariable("id") int id, Model model) {
        Questionnaire questionnaire = questionnaireRepository.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid questionnaire Id:" + id));

        
        model.addAttribute("questionnaire", questionnaire);
        model.addAttribute("classe", classeRepository.findAll());
    	model.addAttribute("matiere", matiereRepository.findAll());
        
        return "update-questionnaireForm";
    }
	
    @PostMapping("/updateQuestionnaire/{id}")
	public String updateQuestionnaire(@PathVariable("id") int id, @Valid Questionnaire questionnaire, BindingResult result, Model model) 
	{
    	questionnaire.setId_questionnaire(id);
		
    	if (result.hasErrors()) 
		{
			questionnaire.setId_questionnaire(id);
	        return "update-questionnaire";
	    }
	   
	    questionnaireRepository.save(questionnaire);
	    model.addAttribute("questionnaire", questionnaireRepository.findAll());
	    
	    return "redirect:/demo/questionnaireList";
	
	}
    
    @GetMapping("/ajoutQuestionnaire")
    public String showSignUpFormQuestionnaire(Questionnaire questionnaire, BindingResult result, Model model) {
    	
    	model.addAttribute("classe", classeRepository.findAll());
    	model.addAttribute("matiere", matiereRepository.findAll());
    	return "questionnaireForm";
    }

    @PostMapping("/addQuestionnaire")
    public String addQuestionnaire(@Valid Questionnaire questionnaire, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "questionnaireList";
        }
        
        questionnaireRepository.save(questionnaire);
        
        model.addAttribute("questionnaire", questionnaireRepository.findAll());
        
        return "redirect:/demo/questionnaireList";
    }
    
	@GetMapping("/deleteQuestionnaire/{id}")
    public String deleteQuestionnaire(@PathVariable("id") int id, Model model) {

        Questionnaire questionnaire = questionnaireRepository.findById((int) id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid questionnaire Id:" + id));

        questionnaireRepository.delete(questionnaire);

        model.addAttribute("questionnaire",questionnaireRepository.findAll());

        return "redirect:/demo/questionnaireList";
    }
	
	@RequestMapping(value = { "/questionList" }, method = RequestMethod.GET)
    public String questionList(Model model) {
         
		model.addAttribute("question", questionRepository.findAll());
        
		
		return "questionList";

    }
	
	
	@GetMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable("id") int id, Model model) {

        
		Question question=questionRepository.findById((int) id)
		.orElseThrow(() -> new IllegalArgumentException("Invalid questionnaire Id:" + id));
		
        questionRepository.delete(question);

        model.addAttribute("question",questionRepository.findAll());

        return "redirect:/demo/questionList";
    }
	
	
	
	@GetMapping("/ajoutQuestion")
    public String showSignUpFormQuestion(Question question, BindingResult result, Model model) {

    	model.addAttribute("questionnaire", questionnaireRepository.findAll());
    	return "questionForm";
    
	}

    @PostMapping("/addQuestion")
    public String addQuestion(@Valid Question question, BindingResult result, Model model) {
        if (result.hasErrors()) {
            
        	return "questionList";
        
        }
        
        questionRepository.save(question);
        
        model.addAttribute("question", questionRepository.findAll());
        
        return "redirect:/demo/questionList";
    }
    
    @GetMapping("/questionUpdate/{id}")
    public String showUpdateFormQuestion(@PathVariable("id") int id, Model model) {
        Question question = questionRepository.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid question Id:" + id));

        model.addAttribute("questionnaire", questionnaireRepository.findAll());
        model.addAttribute("question", question);

        return "update-questionForm";
    }
    
    @PostMapping("/updateQuestion/{id}")
	public String updateQuestion(@PathVariable("id") int id, @Valid Question question, BindingResult result, Model model) 
	{
    	question.setId_question(id);
		
    	if (result.hasErrors()) 
		{
    		question.setId_question(id);
	        return "update-questionForm";
	    }
	   
	    questionRepository.save(question);
	    model.addAttribute("question", questionRepository.findAll());
	    
	    return "redirect:/demo/questionList";
	
	}
    
    @RequestMapping(value = { "/reponseList" }, method = RequestMethod.GET)
    public String reponseList(Model model) {
         
		model.addAttribute("reponse", reponseRepository.findAll());
        
		
		return "reponseList";

    }
    
    @GetMapping("/reponseUpdate/{id}")
    public String showUpdateFormReponse(@PathVariable("id") int id, Model model) {
        Reponse reponse = reponseRepository.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid question Id:" + id));

        model.addAttribute("question", questionRepository.findAll());
        model.addAttribute("reponse", reponse);

        return "update-reponseForm";
    }
    
    @PostMapping("/updateReponse/{id}")
	public String updateReponse(@PathVariable("id") int id, @Valid Reponse reponse, BindingResult result, Model model) 
	{
    	reponse.setId_reponse(id);
		
    	if (result.hasErrors()) 
		{
    		reponse.setId_reponse(id);
	        return "update-reponseForm";
	    }
	   
	    reponseRepository.save(reponse);
	    model.addAttribute("reponse", reponseRepository.findAll());
	    
	    return "redirect:/demo/reponseList";
	
	}
    
    @GetMapping("/reponseDelete/{id}")
    public String deleteReponse(@PathVariable("id") int id, Model model) {

        
		Reponse reponse=reponseRepository.findById((int) id)
		.orElseThrow(() -> new IllegalArgumentException("Invalid reponse Id:" + id));
		
        reponseRepository.delete(reponse);

        model.addAttribute("reponse",reponseRepository.findAll());

        return "redirect:/demo/reponseList";
    }
    
    @GetMapping("/ajoutReponse")
    public String showSignUpFormReponse(Reponse reponse, BindingResult result, Model model) {

    	model.addAttribute("question", questionRepository.findAll());
    	return "reponseForm";
    
	}

    @PostMapping("/addReponse")
    public String addReponse(@Valid Reponse reponse, BindingResult result, Model model) {
        if (result.hasErrors()) {
            
        	return "reponseList";
        
        }
        
        reponseRepository.save(reponse);
        
        model.addAttribute("reponse", reponseRepository.findAll());
        
        return "redirect:/demo/reponseList";
    }
    
    @RequestMapping(value = { "/historiqueList" }, method = RequestMethod.GET)
    public String historiqueList(Model model) {
         
		model.addAttribute("historique", histoRepository.findAll());
        
		
		return "historiqueList";

    }
}